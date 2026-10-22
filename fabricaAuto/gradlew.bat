@echo off
set DIR=%~dp0
if "%DIR%"=="" set DIR=.
set APP_HOME=%DIR%
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

where java >nul 2>nul
if errorlevel 1 (
    echo ERROR: Java was not found. Please set JAVA_HOME or add java to PATH. 1>&2
    exit /b 1
)

java %JAVA_OPTS% %GRADLE_OPTS% -Dorg.gradle.appname=gradlew -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
