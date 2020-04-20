USE DATABASE CaseStudyExperiment;
-- Only need to INSERT INTO in bibleVerses and gameWords. The rest of the data and tables will be generated via EclipseLinkJPA(JDBC)

INSERT INTO bibleVerses(verseId, verseChapter, verseText) VALUES (1, "Genesis 1:1:","In the beginning, God created the heavens and the earth");
INSERT INTO bibleVerses(verseId, verseChapter, verseText) VALUES (2, "Mark 16:15:", "And he said to them, 'Go into all the world and proclaim the gospel to the whole creation'.");
INSERT INTO bibleVerses(verseId, verseChapter, verseText) VALUES (3, "Philippians 4:13:", "I can do all things through him who strengthens me");
INSERT INTO bibleVerses(verseId, verseChapter, verseText) VALUES (4, "Proverbs 18:24:", "A man of many companions may come to ruin, but there is a friend who sticks closer than a brother."); 

INSERT INTO gameWords(wordId, wordName) VALUES (1, "Thank");
INSERT INTO gameWords(wordId, wordName) VALUES (2, "You");
INSERT INTO gameWords(wordId, wordName) VALUES (3, "Per");
INSERT INTO gameWords(wordId, wordName) VALUES (4, "Scholas"); 