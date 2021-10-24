@echo off
color 0a
echo.------------------------------------
echo.TODO:设置java环境变量
echo.
echo.------------------------------------
::如果有的话，先删除JAVA_HOME
wmic ENVIRONMENT where "name='JAVA_HOME'" delete

::创建JAVA_HOME VariableValue 后面是JDK的安装路径,自行更改
 wmic ENVIRONMENT create name="JAVA_HOME",username="<system>",VariableValue="F:\ProgramData\Java\jdk-11.0.12"
pause
