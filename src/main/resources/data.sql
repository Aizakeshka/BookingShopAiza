INSERT INTO author (id, name) VALUES
(6, 'Jane Austen'),
(7, 'Anna Sherry'),
(8, 'Anna Jane'),
(9, 'Fyodor Dostoevsky'),
(10, 'Jack London'),
(11, 'Dmitry Labkovsky'),
(12, 'Alexander Pushkin'),
(13, 'Victoria Pobedinskaya');

INSERT INTO genre (id, name) VALUES
(6, 'Classic Literature'),
(7, 'Psychology'),
(8, 'Adventure'),
(9, 'Poetry'),
(10, 'Romance');

INSERT INTO catalog (id, name) VALUES
(6, 'Russian Classics'),
(7, 'Psychology & Self-Help'),
(8, 'Modern Literature'),
(9, 'Poetry Collection');

INSERT INTO book (id, title, description, year, page_count, author_id, genre_id, catalog_id) VALUES
(16, 'Pride and Prejudice',
'A classic novel exploring manners, marriage, and social standing in 19th century England.',
1813, 432, 6, 6, 8),
(17, 'The Psychology of Happiness',
'An insightful guide into understanding emotions and building a fulfilling life.',
2019, 320, 7, 7, 7),
(18, 'Love and Life',
'A contemporary tale about complex relationships and personal growth.',
2021, 280, 8, 10, 8),
(19, 'Crime and Punishment',
'A profound psychological novel diving into morality, guilt, and redemption in 19th century Russia.',
1866, 671, 9, 6, 6),
(20, 'White Fang',
'The gripping story of a wild wolf-dog’s survival and adaptation in the Yukon Territory.',
1906, 245, 10, 8, 8),
(21, 'Life Without Stress',
'Practical advice and strategies for managing emotions and mental health effectively.',
2015, 350, 11, 7, 7),
(22, 'Eugene Onegin',
'A poetic novel in verse depicting love, society, and fate in early 19th century Russia.',
1833, 350, 12, 9, 9),
(23, 'Modern Russian Women',
'Profiles and stories of influential women shaping contemporary Russia.',
2020, 300, 13, 8, 8);
