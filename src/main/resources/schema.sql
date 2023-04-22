create table if not exists Ingredient(
id varchar(4) not null,
name varchar(25) not null,
type varchar(10) not null
);

create table if not exists Burger(
id identity,
name varchar(50) not exists,
createdAt timestamp not null
);

create table if not exists Burger_Ingredients(
burger bitInt not null,
ingredient varchar(4) not null
)

alter table Burger_Ingredients
 add foreign key (burger) references Burger(id);
alter table Burger_Ingredients
 add foreign key (ingredient) references Ingredient(id);

create table if not exists Burger   Burger_Order (
 id identity,
 deliveryName varchar(50) not null,
 deliveryStreet varchar(50) not null,
 deliveryCity varchar(50) not null,
 deliveryState varchar(2) not null,
 deliveryZip varchar(10) not null,
 ccNumber varchar(16) not null,
 ccExpiration varchar(5) not null,
 ccCVV varchar(3) not null,
 placedAt timestamp not null
);

create table if not exists Burger_Order_Burgers (
 burgerOrder bigint not null,
 burger bigint not null
);

alter table Burger_Order_Burgers
 add foreign key (burgerOrder) references Burger_Order(id);
alter table Burger_Order_Burgers
 add foreign key (burger) references Burger(id);