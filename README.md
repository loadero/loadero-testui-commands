# loadero-testui-commands

## Installation

Loadero TestUI custom commands can be added to your project using Maven. 
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
  <groupId>com.loadero.testui.commands</groupId>
  <artifactId>loadero-testui-commands</artifactId>
  <version>1.0.0</version>
</dependency>
```

The latest tag (or master) always will be the most up-to-date version when 
compared to the commands used in Loadero environment. To change the version, it 
is needed to update the `version` field in `pom.xml` file.

## Usage

These TestUI custom commands were made to simplify local script development 
for usage in Loadero environment. By using these commands, you can write your 
Loadero script locally and then upload it to Loadero without any changes. This 
also allows for more rapid development because it can be debugged and ran 
locally. 

To use the commands in your tests, you need to download this dependency to your 
project (as shown above) and then only import the functions in your 
script file. Keep in mind, that when migrating the script to Loadero, you do not
need to import the functions there as-well, that will be done automatically.

This is how you can import the functions in your script file:

```java
import static com.loadero.testui.FileDownload.waitForDownloadFinished;
import static com.loadero.testui.FileUpload.setFile;
import static com.loadero.testui.NetworkConditioner.updateNetwork;
import static com.loadero.testui.UserAgent.setUserAgent;
import static com.loadero.testui.IgnoreAlert.ignoreAlert;
import static com.loadero.testui.RequestHeader.setRequestHeader;
import static com.loadero.testui.TimeExecution.timeExecution;
import static com.loadero.testui.TimeExecution.Command;
```

After which they can be used in your script file as any other function. 
Script example:

```java
public void testUIWithLoadero() {
    int reallyLongPause = 5 * 60 * 1000; // 5 minutes
    open("https://duckduckgo.com/");

    // Example of timing execution without specifying a timeout.
    timeExecution(
        "locate_search_bar_and_wait",
        () -> {
            E(byCssSelector("#search_form_input_homepage"))
                .waitFor(10)
                .untilIsVisible()
                .sendKeys("loadero");
            E(byCssSelector("#search_button_homepage"))
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

## Commands

Not all commands behave the same way as they do in Loadero environment. Some of 
them are modified to work in local environment. Such as `updateNetwork` and 
`setRequestHeader`. The following table shows all available commands and if they 
will behave the same in both environments.

| Command                   | Differences                                                                            |
| ------------------------- | -------------------------------------------------------------------------------------- |
| `ignoreAlert`             | No differences                                                                         |
| `setFile`                 | Any local file can be used, Loadero constant can be used if the same file name is used |
| `setRequestHeader`        | No request header will be set                                                          |
| `setUserAgent`            | User agent won't be changed                                                            |
| `timeExecution`           | Execution time will be logged, but not saved                                           |
| `updateNetwork`           | Network settings will not be updated                                                   |
| `waitForDownloadFinished` | Function will finish instantly and not wait for download to be finished                |

Full descriptions for each function and their usage can be found in 
[Loadero wiki](https://wiki.loadero.com/testui/custom-commands/) page.
