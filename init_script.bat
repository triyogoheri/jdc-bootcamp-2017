@echo off
"C:\Program Files\PostgreSQL\9.6\bin\psql.exe" -h localhost -U postgres -d jdc-engine -f C:/Users/rifi/Documents/agit-jdc/com.agit.jdc.usermanagement/src/main/resources/script/init_script_agit_jdc_project.sql
pause