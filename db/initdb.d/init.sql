CREATE TABLE IF NOT EXISTS food_memo.memo
(
    id      int primary key auto_increment,
    title   varchar(255),
    content varchar(500)
);

CREATE TABLE IF NOT EXISTS food_memo.image
(
    id      int primary key auto_increment,
    memo_id int           NOT NULL,
    path    varchar(1000) NOT NULL
);
