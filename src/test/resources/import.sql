INSERT INTO "USER" ( ID, ACTIVE, LAST_CONNECTION, NAME, USER_NAME, UUID ) VALUES (1 ,TRUE ,CURRENT_TIMESTAMP , 'John Smith', 'jsmith', '123654789')
INSERT INTO "USER" ( "ID", "ACTIVE", "LAST_CONNECTION", "NAME", "USER_NAME", "UUID" ) VALUES (2 ,TRUE ,CURRENT_TIMESTAMP , 'Kevin Smith', 'ksmith', '9853264175')
INSERT INTO "USER" ( "ID", "ACTIVE", "LAST_CONNECTION", "NAME", "USER_NAME", "UUID" ) VALUES (3 ,TRUE ,CURRENT_TIMESTAMP , 'Kevin Connor', 'kconnor', '4585256585212325')

INSERT INTO "ROOM" ( "ID", "NAME" ) VALUES ( 1, 'public')

INSERT INTO "ROOM" ( "ID", "NAME" ) VALUES ( 2, 'topics')
INSERT INTO "ROOM_MEMBER" ( "ROOM_ID", "USER_ID" ) VALUES (1 ,1 ), (1,2),(2,3),(2,2)

INSERT INTO "MESSAGE" ( "TYPE", "ID", "CONTENT", "TIMESTAMP", "SENDER_ID",  "ROOM_ID" ) VALUES ( 'PUBLIC',1 , 'Hello',CURRENT_TIMESTAMP ,1 , 1 ),( 'PUBLIC',2 , 'Hi',CURRENT_TIMESTAMP ,2 ,1 ),( 'PUBLIC',3 , 'how are you?',CURRENT_TIMESTAMP ,1 ,1 )
INSERT INTO "MESSAGE" ( "TYPE", "ID", "CONTENT", "TIMESTAMP", "SENDER_ID", "RECEIVER_ID", "ROOM_ID" ) VALUES ( 'PRIVATE', 4, 'Hi Kev',CURRENT_TIMESTAMP , 1,2 , NULL)
INSERT INTO "MESSAGE" ( "TYPE", "ID", "CONTENT", "TIMESTAMP", "SENDER_ID", "RECEIVER_ID", "ROOM_ID" )VALUES ( 'PRIVATE', 5, 'Hi John',CURRENT_TIMESTAMP , 2,1 , NULL)