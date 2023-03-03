# Chess

## Graduate project of the 2nd semester of IU-1 in the discipline GUI applications


<p align="center">
  <img src="src/main/resources/icon.png" width="150" title="hover text">
</p>

-----
### Menu
-----
![](/src/main/resources/images/menu.gif)
```java
@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("enter-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Just Chess");
        stage.getIcons().add(new Image("icon.png"));

        stage.setScene(scene);
        stage.show();
    }
```
-----
### Initial Local Game
-----
```java
@FXML
    private void startLocalGame(MouseEvent event) throws IOException {
        PlayFieldController playFieldController = startGameScene(event);

        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        playFieldController.startGame(firstPlayer, secondPlayer);
    }
```
-----
### Figure
-----
```java

public interface Figure {

    enum Color {
        WHITE,
        BLACK
    }
    public Pair<Integer, Integer> getCoordinates();
    
    public Color getColor();
    
    public ImageView getFigureModel();
    
    public boolean canMakeMove(int row, int column);
    
    public void makeMove(int row, int column);
    
}

```
Figure Black | ![](src/main/resources/images/KingB.png) | ![](src/main/resources/images/QueenB.png) | ![](src/main/resources/images/KnightB.png) | ![](src/main/resources/images/BishopB.png) | ![](src/main/resources/images/RookB.png) | ![](src/main/resources/images/PawnB.png)
----- | ----- | ----- | ----- |----- |----- |-----
Figure White | ![](src/main/resources/images/KingW.png) | ![](src/main/resources/images/QueenW.png) | ![](src/main/resources/images/KnightW.png) | ![](src/main/resources/images/BishopW.png) | ![](src/main/resources/images/RookW.png) | ![](src/main/resources/images/PawnW.png)
-----
# Developers:
  - Romanov Maxim (https://github.com/koldun8010)
  - Repin Pavel (https://github.com/thxtomslf)
  
### TeamLead
  - Shevchenko Alexey (https://github.com/Alex777Russia)

# Mentor:
  - Nikolaev Artem (https://github.com/nicepeopleproject)
