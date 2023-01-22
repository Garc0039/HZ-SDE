## Welcome to my pattern implementation assignment!
I have been wokring on this repo by myself. I did use as a matter of facts this: https://github.com/HZ-HBO-ICT/sde_facade repo.
I had an assignment as to how to apply the Facade pattern which can be found here: https://github.com/Garc0039/HZ-SDE/tree/SDE-Lecture-2.
The second link is the repo I used as my codebase since it was my own work to begin with.

### How to run the code?
So if you decide that you would like to have a peak at this masterpiece of code, ensure that you first clone it.
Open the repo in an IDE that supports JAVA and that is all you have to do. Be ready to click the play
button and to get compiling because everything is already setup and a little demo will appear in the console.
I tried to make the code a bit less boring by implementing user input to make it a bit more interactive rather than
looking at a couple of println() yet it is nothing big either. The codebase is simply there for my SDE assignment
and to experiment and get to know a couple of patterns!

Enjoy the demo and the exploring of my small little code mess!

### So what has been done in this repo?
The assignment I had to work on was to implement at least 1 of each pattern classification,
 meaning a creational pattern, a structural pattern, and a behavioral pattern. So I got working
and decided to with the builder and singleton pattern as my creational patterns, the facade and proxy patterns
as my structural patterns, and the strategy and template patterns as my behavioral patterns.

### How did they get implemented?
#### Builder & Proxy & Strategy & Facade
The builder pattern is set up in a way that it sets up and builds the gaming environment.
This is done via the GamingSetupBuilder who talks to the GamingProxy, which adds the proxy pattern
to the code base, to the StopGamingEnvStrategy and StartGamingEnvStrategy, which add the strategy patter :) 
Those patterns make use of the Builder Interface, GamingEnvironment Interface, and the Strategy Interface.
All of those classes and their respective objects can be found inside the facade pattern and some specific 
object you are looking for must be looked upon manually ;) what a charm. The facade class happens to be the main
runner of the codebase as it hides all the complexity and ugly code behind its own class.

#### Singleton & Template
So the singleton patterns is applied via the Database class meaning that it only exists once throughout
the whole compiling and running of the code, which is the goal of the singleton pattern, rather easy to understand
isn't it. The template pattern can be found within the GameAI, CocAI, and ForzaAI classes. The GameAI class
happens to be the mother class for CocAI, and ForzaAI and servers as a *template* for both classes reusing the mother contructor
and adding their own logic to the abstract methods of the GameAI class.
