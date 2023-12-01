# loadero-testui-commands [![JitPack](https://img.shields.io/jitpack/version/com.github.loadero/loadero-testui-commands)](https://jitpack.io/#loadero/loadero-testui-commands)

## Installation

Loadero TestUI custom commands can be added to your project using Maven and Gradle.

### Maven

To do so, first Jitpack has to be added as a repository to your `pom.xml` file:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Then add `loadero-testui-commands` as a dependency:

```xml
<dependency>
  <groupId>com.github.loadero</groupId>
  <artifactId>loadero-testui-commands</artifactId>
  <version>1.0.1</version>
</dependency>
```

### Gradle (Kotlin)

Add following lines to `build.gradle.kts`

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.loadero:loadero-testui-commands:1.0.1")
}
```

### Gradle (Groovy)

Add following lines to `build.gradle`

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.loadero:loadero-testui-commands:1.0.1'
}
```

The latest tag will always be the most up-to-date version when compared to the
commands used in Loadero environment.

## Usage

These TestUI custom commands were made to simplify local script development
for usage in Loadero environment. By using these commands, you can write your
Loadero script locally and then upload it to Loadero. This also allows for more
rapid development because the script can be debugged and run locally.

To use the commands in your tests, you need to download this dependency to your
project (as shown above) and then only import the functions in your
script file. Keep in mind, that when migrating the script to Loadero, you do not
need to import the functions there as-well, that will be done automatically.

This is how you can import the functions in your script file:

```java
import com.loadero.testui.commands.Conditioner;
import com.loadero.testui.commands.ConditionerBuilder;
import com.loadero.testui.commands.EmailMessage;

import static com.loadero.testui.commands.FileDownload.waitForDownloadFinished;
import static com.loadero.testui.commands.FileUpload.setFile;
import static com.loadero.testui.commands.NetworkConditioner.updateNetwork;
import static com.loadero.testui.commands.UserAgent.setUserAgent;
import static com.loadero.testui.commands.IgnoreAlert.ignoreAlert;
import static com.loadero.testui.commands.ReceiveEmail.receiveEmail;
import static com.loadero.testui.commands.ReceiveEmail.genEmail;
import static com.loadero.testui.commands.RequestHeader.setRequestHeader;
import static com.loadero.testui.commands.TimeExecution.timeExecution;
```

After which they can be used in your script file as any other function.
Script example:

```java
public void testUIWithLoadero() {
    int reallyLongPause = 5 * 60 * 1000; // 5 minutes
    open("https://duckduckgo.com/");

    // Example of timing execution without specifying a timeout.
    timeExecution(
        "locate_search_bar",
        () -> {
            E(byCssSelector("#searchbox_input"))
                .waitFor(10)
                .untilIsVisible()
                .sendKeys("QA Processes");
            E(byCssSelector("[aria-label='Search']"))
                .waitFor(10)
                .untilIsVisible()
                .click();
            E(byCssSelector("#r1-0 > div > h2"))
                .waitFor(10)
                .untilIsVisible();
            sleep(reallyLongPause);
        }
    );
}
```

Not all commands behave the same way as they do in Loadero environment. Some of
them are modified to work in local environment. Such as `updateNetwork` and
`setRequestHeader`. The following table shows all available commands and if they
will behave the same in both environments.

## Commands

The following table shows all available commands and whether there are any
changes to how they function in a local environment.

Full descriptions for how each function behaves in Loadero and their usage can
be found in [Loadero wiki](https://wiki.loadero.com/docs/testui-java/custom-commands/)
page. To see the differences between local and Loadero environment, you can
compare the descriptions in the wiki to the differences mentioned in this README.

| Command                   | Differences                                                                                                                                   |
| ------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| `ignoreAlert`             | No differences                                                                                                                                |
| `setFile`                 | Any local file can be used, Loadero constant can be used if the same file name is used                                                        |
| `setRequestHeader`        | No request header will be set                                                                                                                 |
| `setUserAgent`            | User agent won't be changed                                                                                                                   |
| `timeExecution`           | Execution time will be logged, but not saved                                                                                                  |
| `updateNetwork`           | Network settings will not be updated                                                                                                          |
| `waitForDownloadFinished` | Function will finish instantly and not wait for download to be finished                                                                       |
| `genEmail`                | Full email or only first part can be provided, if only the first part is provided than `@mailinator` is appended                              |
| `receiveEmail`            | By default an empty array will be returned, but `emails.json` file can be saved in the working directory which will contain all of the emails |

The `emails.json` file should be located in the same directory where `pom.xml` file is located in your project and should have the following structure:

```json
{
  "address": "email_address",
  "emails": [
    {
      "from": "email_from",
      "to": "email_to",
      "headers": {
        "header1": "header_value"
      },
      "subject": "email_subject",
      "text/html": "html body",
      "text/plain": "plain text body"
    }
  ]
}
```
