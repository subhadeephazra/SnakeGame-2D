It is a GUI-based Java project which is created using the Object-Oriented programming principles such as inheritence, abstraction, and encapsulation. It uses the JAVA Swing and AWT library to organize all the elements.

It icludes two main classes:

Snake (extends JFrame and invokes the GameControl class)
GameControl (extends JPanel)
The GameControl class provides following methods:

GameControl() - It initializes Board Panel.
loadImages() - It loads images of Snake head, Snake body and food.
initGame() - It initializes Game.
checkCollision() - It checks collision of Snake's head with an obstacle (itself/food/wall).
locateApple() - It randomize Apple position every time.
gameOver() - It displays Game Over massage and player's score.

This game includes the following functionalities:

The player can move the snake left, rigt, up, and down as per the given direction using respective arrow keys.
Whenever the snake eats food, its length increases by one and live score is displayed on screen.
The food appears on random position each time, either when the snake eats one or the new game is started.
When the snake collides with itself or with any of the wall, the "Game Over" massage it displayed along with player's score.

Design elements -

Snake head: represented by green dot.
Snake body: represented by red dot.
Food: represented by an apple.

Play Screen -

![UI](https://github.com/subhadeephazra/SnakeGame-2D/assets/124555668/7182f37c-6549-40ea-8aab-6449864e8ee8)

Game Over -

![gameover](https://github.com/subhadeephazra/SnakeGame-2D/assets/124555668/e2827223-31c2-49b6-944f-ff67bf89d224)
