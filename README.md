# TABLES
  
### B_USERS
| 이름     | 널?       | 유형            | PK/FK |
| ------ | -------- | ------------- | ----- |
| USERID | NOT NULL | VARCHAR2(20)  | PK    |
| USERNM |          | VARCHAR2(20)  |
| PASS   |          | VARCHAR2(100) |

### B_BOARDS
| 이름         | 널?       | 유형            | PK/FK |
| ---------- | -------- | ------------- | ----- |
| BOARD_ID   | NOT NULL | NUMBER        | PK    |
| BOARD_NAME |          | VARCHAR2(200) |
| BOARD_USE  |          | CHAR(1)       |
| USERID     |          | VARCHAR2(20)  | FK    |
| BOARD_TIME |          | DATE          |

### B_POSTS
| 이름          | 널?       | 유형            | PK/FK |
| ----------- | -------- | ------------- | ----- |
| POST_ID     | NOT NULL | NUMBER        | PK    |
| BOARD_ID    |          | NUMBER        | FK    |
| POST_TITLE  |          | VARCHAR2(200) |
| POST_CONT   |          | CLOB          |
| USERID      |          | VARCHAR2(20)  | FK    |
| POST_TIME   |          | DATE          |
| POST_PARENT |          | NUMBER        |
| POST_DEL    |          | CHAR(1)       |
| GN          |          | NUMBER        |

### B_ATT_FILES
| 이름       | 널?       | 유형            | PK/FK |
| -------- | -------- | ------------- | ----- |
| ATT_ID   | NOT NULL | NUMBER        | PK    |
| AT_NAME  |          | VARCHAR2(200) |
| ATT_PATH |          | VARCHAR2(200) |
| POST_ID  |          | NUMBER        | FK    |

### B_COMMENTS
| 이름       | 널?       | 유형             | PK/FK |
| -------- | -------- | -------------- | ----- |
| CMT_ID   | NOT NULL | NUMBER         | PK    |
| CMT_CONT |          | VARCHAR2(1500) |
| CMT_TIME |          | DATE           |
| POST_ID  |          | NUMBER         | FK    |
| USERID   |          | VARCHAR2(20)   | FK    |
| CMT_DEL  |          | CHAR(1)        |

