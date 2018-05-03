# Java-Chat-Application
<h3>This is a Java Web Services based Chat Application</h3>
<h4>Both the Web Service and the Client Application is present in this repository</h4><br>
<p>The Graphical User Interface of the application is developed using Java Swing Library.<br>
  The Application uses a MySQL Database. The Web Service used in this application is a RESTful Web Service and uses Object Relational Mapping. The Client of the Application uses SOAP to communicate with the Web Service. The user will be able to exchange messages with other users and also post messages in threads. Any User may create a thread and/or rename a thread. A User becomes a participant of a thread if they post a message in the thread. All threads are public and can be viewed by any user. A user will be able to message another user by viewing them through the participants section of a Thread (See Screenshots to get a proper understanding). The user also has the option to change their password. The user will be able to view the last edited date and time of each thread by the Nickname of the user by whom the thread was edited. For each participant, their Nickname, Login ID and their registration date is displayed. <br>The Swing Application runs on the Swing Thread while a seperate thread is initialized and runs in the background to allow the user to receive new messages. All messages, threads and participants of each thread are stored in a List (but not personal messages). The list is updated via the background thread. The thread checks the size of the lists and compares them with the data received from the database. If the sizes are different (List Size < Result of Database), the lists are updated with the data.</p> <br>

<p>The Following features are present in the application: <br> 
<ul><li>Login</li><li>Register</li><li>Create Threads</li></li><li>ViewThreads</li><li>Rename Threads</li><li>Send Messages to the Threads</li><li>View Participants of a Thread</li><li>Send messages to a Participant of a Thread</li><li>Search Threads</li></ul>
<br /><h4>More features are coming soon</h4>

<br>

<h3>TODO</h3>
<ul>
  <li>Display both Users and Threads in the right panel at the same time.</li>
  <li>Search for Users</li>
  <li>Search through messages of a Thread</li>
</ul>

<br>

<h3>Screenshots of the Application</h3>
<p align="center">
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/Login.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/register.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/ThreadsGUI.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/View%20messages%20of%20a%20thread.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/View%20Participants%20of%20a%20thread.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/Search.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/Create%20New%20Thread.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/change%20password.png"><br/>
<img src="https://raw.githubusercontent.com/minojsos/Java-Chat-Application/master/ChatR_Client/Screenshots/Rename%20Thread.png"><br/>
</p>
