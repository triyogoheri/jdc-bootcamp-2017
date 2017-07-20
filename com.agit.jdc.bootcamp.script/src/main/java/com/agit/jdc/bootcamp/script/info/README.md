# Bitozen-Project
This is BITOZEN Project Package - Bitozen Project
Created By : Bayu Dewanto 

1. Dump database Oracle
import = exp / idp
import = expdp / imdp
cara 1 : exp USRAPPSHOST/password file=d:\DMP_USRAPPSHOST.dmp
cara 2 : expdp USRAPPSHOST/password file=d:\DMP_USRAPPSHOST.dmp

2. Letakan dump file EVAT.DMP di
C:\oraclexe\app\oracle\admin\XE\dpdump

3. jalankan script di cmd 
cara 1 : imp USRAPPSHOST/password@localhost:1521/xe file=C:\oraclexe\app\oracle\admin\XE\dpdump\USRAPPSHOST.dmp full=yes
cara 2 : impdp system/system@localhost:1521/xe dumpfile=EVAT.DMP SCHEMAS=USRAPPSHOST table_exists_action=replace



4. Create Index for User, Role, Privilege for speed up UI process
CREATE INDEX mst_role_idx ON mst_role (id_role,roleid);
CREATE INDEX mst_role_user_idx ON mst_user (id_user,roleid,username);
CREATE INDEX mst_role_privilege_idx ON mst_role_privilege (roleid,role_privilege_index,privilegeid);

