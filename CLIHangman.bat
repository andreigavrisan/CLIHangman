@ECHO OFF

goto start
ECHO ----------Building Java Classes----------
javac src/myCLIHangman/Main.java
PAUSE
CLS

:start
ECHO ----------Starting----------------------
java -cp ./bin;. myCLIHangman.Main

set /p REPLAY=Play again?
if %REPLAY%==y goto start

ECHO =============Exiting====================
PAUSE


