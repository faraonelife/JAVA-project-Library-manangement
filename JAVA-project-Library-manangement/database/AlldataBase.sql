DROP TABLE book;
DROP TABLE Librarian;
DROP TABLE borrowedB;
DROP TABLE Student;

CREATE TABLE book(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  bookNO VARCHAR(50) NOT NULL,
  name VARCHAR(20) NOT NULL,
  author VARCHAR(50) NOT NULL,
  publisher VARCHAR(35) NOT NULL,
  quantity INT NOT NULL,
  borrowed INT
);

CREATE TABLE Librarian(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);
CREATE TABLE Student(
  studenid INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  address VARCHAR(200) NOT NULL,
  city VARCHAR(100) NOT NULL,
  contact VARCHAR(20) NOT NULL
);
CREATE TABLE borrowedB(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  bookBorNo VARCHAR(50) NOT NULL,
  studentid INT NOT NULL,
  studentname VARCHAR(50) NOT NULL,
  borrowdata timestamp NOT NULL,
  returndata timestamp NOT NULL
);

INSERT INTO Student(name,password,email,address,city,contact) VALUES
('boruto','borbor','boruto@mail.ru','nukus str','tash','+998991234566'),
('naruto','narnar','naruto@mail.ru','yakkasaroy str','tash','+998887654321'),
('faraonelife','fara','faraonelife@mail.ru','severniy str','tash','+998934568437');

INSERT INTO borrowedB(bookBorNo, studentid, studentname,borrowdata,returndata) VALUES
('num1', 1,'boruto','2021-01-05 13:46:12','2021-01-14 13:46:12'),
( 'num2', 2, 'naruto','2021-01-05 13:43:12','2021-01-14 13:46:12'),
('num3',3, 'faraonelife','2021-01-05 13:41:12','2021-01-14 13:46:12');

INSERT INTO book(bookNO, name, author, publisher, quantity, borrowed) VALUES
('num1', 'java','James Bond','TAshMoshFarm',4,0),
('num2', 'c++','Lara Kroft','UrgPurgXoz',7,0),
('num3', 'rog','Alexandr Pushkin','SamArKand',3,0);

INSERT INTO Librarian (name, password) VALUES
('farxod','123' ),
('fara', '1111'),
('qwe', '1q2w3e');