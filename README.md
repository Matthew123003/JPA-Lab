# TCUK - JPA
This lab has the same goals of the JDBC lab, but using JPA.

The setup for the database stuff is the same as in the JDBC lab, so see the README from that lab for getting connected 
to the database in case you forgot.  The `data-h2.sql` file is here again, too.  
This will give you some cases to test against.  Feel free to add your own stuff and to modify that SQL file.  
It's here to help you out.

## Step 0 -- Getting Set Up
The scaffolding has been done for the first part for you.  Since one of the hardest, most daunting parts of creating 
software is just starting, all of the interfaces have been built out and everything to
create a person has been completed.  We've started for you!  Now, you don't have to worry about imports and package
structures.  Just start coding.  You'll have to do all of these things yourself for the second part, however.  So
first read through what's happening and understand why everything is there.  If you forget what's going on you can also 
look back at the Spring lab for some help.

As far as the project structure is concerned:
* The controllers are how we interface our software with the outside world.  They define what the user can ask us for
and how it all gets returned.
* The models are the actual data structures that we want to represent.  In this case, we need Persons and Homes.
* The repositories are where all the database logic actually happens.
    * Spring JPA handles most of this for us, though.
* The services are what call the repositories and do the actual computation requested by the controllers.

## Step 1 -- People
For this first part, we want to handle Creating, Reading, Updating, and Deleting people from our database.  The schema
is in the `resources/schema-h2.sql` file, and you can view it in the H2 console as well.

We need our application to adhere to the following API:

|HTTP Method|Endpoint|What It Does|
|-|-|-|
|POST|/people|Create a person|
|PUT|/people/{id}|Update person with id. 404 error if that person doesn't exist yet|
|GET|/people/{id}|Get the person with the specified ID|
|DELETE|/people/{id}|Delete the person with the specified ID|
|GET|/people|get all people in the database|
|GET|/people/reverselookup/{mobileNumber}|Find all people with the specified mobile number|
|GET|/people/surname/{lastName}|Find all people with a particular last name|
|GET|/people/surname/stats|Get the report of all the last name frequencies (Name, Count)|
|GET|/people/firstname/stats|Get the report of first name frequencies (Name, Count)|
|GET|/people/birthday/stats|Get the report of all the birthday frequencies (Date, Count)|


In addition to those endpoints, we're going to want our service to be able to:
* Remove a list of people from the database
* Find everyone with a particular first name.
* Find everyone with a particular birthday.

I know it might seem weird to have these in the service without the controller calling them, but this is very common
when writing software.  A lot of times you're going to want internal service calls that can do things that you don't
want to expose to the end user.

Also, remember that you can "test" your services with a unit test like we did with the Pluralsight walkthrough.

## Step 2 -- Homes
Remember how we didn't do much with the `homes` part of the data.  We left the `home_id` null for a person and we also
never made any references to that table?  Well, now it's time to do that.

Remember, you're going to need a controller, model, repository, and service for the homes.  We want to be able to:

* Add a home to the database
* Add a person to a home
* Remove a person from a home
* Update an existing home
* Delete a home from the database
* Delete a list of homes from the database
* Find a home by id
* Find a home by home number
* Find a home by address
* Find a home by person
* Get a list of people who live in a certain home
* Get all of the homes

Notice when you try and get things that don't exist in the database we get an error?  
Fix that.  Just make it so that requesting an item doesn't return anything as opposed to throwing the exception.