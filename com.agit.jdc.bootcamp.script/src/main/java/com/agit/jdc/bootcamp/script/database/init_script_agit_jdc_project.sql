-- ----------------------------
-- Records of mst_privilege
-- ----------------------------
INSERT INTO "public"."jdc_mst_privilege" VALUES ('0', 'ROOT', 'ROOT', 'DELETED', null, 't', 'Dashboard', 'Dashboard', null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('1', 'ADMINISTRATOR', 'Administrator', 'ACTIVE', 'ROOT', 't', 'Administrator', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('2', 'GROUP', 'Group', 'ACTIVE', 'ADMINISTRATOR', 't', 'Group Management', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('3', 'GROUP_SEARCH', 'Group Search', 'ACTIVE', 'GROUP', 't', 'Search', 'Group - Maintenance', null, '~./ui/fnd/group/search.fnd.group.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('4', 'GROUP_UPDATE', 'Group Update', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('5', 'GROUP_VIEW', 'Group View', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('6', 'GROUP_DELETE', 'Group Delete', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('7', 'GROUP_CREATE', 'Group Create', 'ACTIVE', 'GROUP', 't', 'Create', 'Group - Create', null, '~./ui/fnd/group/create.fnd.group.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('8', 'USER_MANAGEMENT', 'User', 'ACTIVE', 'ADMINISTRATOR', 't', 'User Management', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('9', 'USER_SEARCH', 'User Search', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Search', 'User - Maintenance', null, '~./ui/fnd/user/search.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('10', 'USER_UPDATE', 'User Update', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('11', 'USER_VIEW', 'User View', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('12', 'USER_DELETE', 'User Delete', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('13', 'USER_RESET_PASSWORD', 'User Reset Password', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('14', 'USER_LOCK_UNLOCK', 'User Lock Unlock', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('15', 'USER_CREATE', 'User Create', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Create', 'User - Create', null, '~./ui/fnd/user/create.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('16', 'USER_RELEASE', 'User Release', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Release', 'User - Release', null, '~./ui/fnd/user/release.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('17', 'MENU', 'Menu Dashboard', 'ACTIVE', 'ADMINISTRATOR', 't', 'Menu Management', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('18', 'MENU_DASHBOARD', 'Menu Dashboard', 'ACTIVE', 'MENU', 't', 'Menu - Dashboard', 'Menu - Dashboard', null, '/zk-layout/privilege/dashboard.privilege.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('19', 'COMPANY', 'Company Dashboard', 'ACTIVE', 'ADMINISTRATOR', 't', 'Company Management', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_privilege" VALUES ('20', 'COMPANY_DASHBOARD', 'Company Dashboard', 'ACTIVE', 'COMPANY', 't', 'Company - Dashboard', 'Company - Dashboard', null, '/zk-layout/company/dashboard.company.zul', '2016-01-01 00:00:00', 'SYSTEM');
-- ----------------------------
-- Records of mst_role
-- ----------------------------
INSERT INTO "public"."jdc_mst_role" VALUES ('1', 'SUPERADMIN', 'SUPERADMIN', 'SUPERADMIN', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."jdc_mst_role" VALUES ('2', 'ADMIN', 'ADMIN', 'ADMIN', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."jdc_mst_role" VALUES ('3', 'USER', 'USER', 'USER', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
-- ----------------------------
-- Records of mst_role_privilege
-- ----------------------------
INSERT INTO "public"."jdc_mst_role_privilege" VALUES ('1', '1', 'ALLOW', '0');
INSERT INTO "public"."jdc_mst_role_privilege" VALUES ('2', '2', 'ALLOW', '0');
INSERT INTO "public"."jdc_mst_role_privilege" VALUES ('2', '8', 'ALLOW', '1');
INSERT INTO "public"."jdc_mst_role_privilege" VALUES ('2', '17', 'ALLOW', '2');
INSERT INTO "public"."jdc_mst_role_privilege" VALUES ('3', '19', 'ALLOW', '0');
-- ----------------------------
-- Records of mst_user
-- ----------------------------
INSERT INTO "public"."jdc_mst_user" VALUES ('1', 'SUPERADMIN', '$2a$10$vW7zns/PRqfHgaxN3DpJuuH2n1mI152gMxO6Lnm4X6zrAEXDPBAUC', 'USER001', '0001', 'ACTIVE', '1', 'Super Admin', 'superadmin@ag-it.com', '08111111111', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, null, null, null, '2017-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_user" VALUES ('2', 'ADMIN', '$2a$10$vW7zns/PRqfHgaxN3DpJuuH2n1mI152gMxO6Lnm4X6zrAEXDPBAUC', 'USER002', '0002', 'ACTIVE', '2', 'Admin', 'admin@ag-it.com', '08111111111', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, null, null, null, '2017-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."jdc_mst_user" VALUES ('3', 'LINTANG', '$2a$10$57J57UK4Wxa6GUWig2QyA.KYv5GgiHeXUIUppRtmczWSlTJd35iba', 'USER003', '0003', 'ACTIVE', '3', 'Heri Triyogo', 'lintang@ag-it.com', '081296924161', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, null, null, null, '2017-01-01 00:00:00', 'SYSTEM');
