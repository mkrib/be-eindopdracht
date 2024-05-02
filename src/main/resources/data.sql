INSERT INTO reservations (start_Time, date, amount_Of_Guests) VALUES ('18:00:00', '2024-04-20', 2),
                                                                     ('19:30:00', '2024-04-28', 4),
                                                                     ('17:30:00', '2024-05-20', 6);
INSERT INTO reviews (full_Name, content, issue_Date) VALUES ('Piet Jansen', 'Heerlijk gegeten, ik kom zeker nog eens terug!', '2024-04-30'),
                                                            ('Marie Dekker', 'Wat een gezellige plek!', '2024-05-30'),
                                                            ('Ellis', 'Zeer vriendelijk personeel.', '2024-06-20');

-- TODO eigen users bedenken
INSERT INTO users (username, password) VALUES ('user', '$2y$10$33tyI/T.dUvdrCvX1Ao/B.iLDtULQpgCCOB6YgFCQDjMBQgaOiu..');
INSERT INTO users (username, password) VALUES ('admin', '$2y$10$HGacaJYGP55U8BUQaZ.CCegOuvrALrrN71QldVbF3D15UU15Mnh.W');

INSERT INTO roles (username, role) VALUES ('user', 'ROLE_USER');
INSERT INTO roles (username, role) VALUES ('admin', 'ROLE_ADMIN');


