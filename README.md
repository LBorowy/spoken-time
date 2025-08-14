# spoken-time
Small CLI application, which outputs the British spoken form of a time given as input.


## How to start (gradle wrapper)
- Linux/Mac
./gradlew run --args=<H:mm>

- Windows
.\gradlew.bat run --args=<H:mm>

After using foojay plugin, Gradle should automatically download JDK 21 at the first run.

### Approach
After consultation, my rule for time when minutes are >30 is that i want to return time "to next hour".
For example: \
6:34 -> twenty six to seven (good) \
6:34 -> six thirty four (bad) 

And I treat input 3:13 and 15:13 as the same hours on output.
