Starting a local game.
Implemented so far:
1)Click passed the title screen
2)Create a new user with the register button
3)Login
4)Select Multiplayer
5)Select Create duel
6)Choose 3 animals for your team (and name them)
7)Game screen will initialize your name, animal, and picture on the left side
Comments: player 2 is hard coded in. All animals work for the most part, some
attacks are not full usable but the core "attacks" all have values. Also specials work, but not defend.
(if you hover over attacks in the gamescreen it will show a description of the attack.)

*****IF THE ABOVE DOES NOT WORK, IT IS DUE TO IMPROPER HEAP SIZE ALLOCATION, IN THAT CASE RUN
THE JAR FILE INCLUDED INSTEAD, BY TYPING "java -jar -Xmx1024m AnimawlTestMAINGUI.jar".
ALSO FOR BELOW OF THE ANT RUN, MAY CHANGE FOR THIS COMMAND INSTEAD.*****


How to build file
find the source directory in terminal
this directory should have the build.xml file in it.
from here, type "ant clean"
this will clean the files of the .class files
next type "ant run"
this will do "ant run" plus "ant compile"
from here the window will pop up and you will be able to playtest the game. (look below for additional ant tasks)

***To run an "online" local multiplayer, you must open two instances of the ant run main class.
From here go through one instance until you reach the multiplayer menu.  
	Pick to host a match. Continue to the battleground select screen.
On the second one go through until you reach multiplayer menu.
	Pick to join a match. Continue to the battleground select screen.
-Once both have clicked confirm on the battleground select they should
connect and you will be able to battle locally.

*To run the chat server test classes, you must open two instances with one being the "ant chat_Server" 
	and the other being "ant chat_Client".  Open the server one first and the client second.
	They should connect, and it will demonstrate a basic chat class that we would have put in the game.

*To run the GameScreen server test classes, you must open two instances with one being the "ant gameScreen_Server" 
	and the other being "ant gameScreen_Client". Open the server one first and the client second.
	They should connect with hardcoded values and you will be able to run the game without going all the 
	way through the "ant run" main.