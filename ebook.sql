create table users(
    id int primary key not null auto_increment,
    name varchar(50) unique,
    password varchar(50),
    role int check (role in (1,2)),
    createddate date,
    updateddate date
);
create table category(
    genre int PRIMARY KEY,
    nameCate varchar(50)
);
create table books(
    bookID int,
    title varchar(50),
    author varchar(50),
    years int,
    genre int,
    status int check (status REGEXP '[1-3]{1}'),
    qty int,
    price decimal(10,1),
    createddate date,
    updateddate date,
    CONSTRAINT pk_books PRIMARY KEY(bookID,title),
    CONSTRAINT fk_category FOREIGN KEY (genre) REFERENCES category(genre)
    );
create table customers(
    customerID int,
    name varchar(50),
    address varchar(50),
    email varchar(50),
    phone varchar(10) check (phone REGEXP '[0-9]{10}'),
    member int check (member REGEXP '[1-4]{1}'),
    createddate datetime,
    updateddate datetime,
    CONSTRAINT fk_id FOREIGN KEY (customerId) REFERENCES users(id)
    );

create table orders(
    orderID int PRIMARY KEY auto_increment,
    customerID int,
    discount int,
    total decimal(10,1),
    orderdate date,
    status int check (status REGEXP '[0-5]{1}'),
    createddate date,
    updateddate date,
    CONSTRAINT fk_customer FOREIGN KEY (customerID) REFERENCES users(id)
    );

create table orderdetail(
    orderID int,
    bookID int,
    title varchar(50),
    amount int,
    price decimal(10,1),
    createddate date,
    updateddate date,
    CONSTRAINT fk_detail FOREIGN KEY (bookID, title) REFERENCES books(bookID,title),
    CONSTRAINT fk_detail2 FOREIGN KEY (orderID) REFERENCES orders(orderID)
);