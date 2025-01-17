
package Main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.text.DecimalFormat;

public class UI {
    Graphics2D g2;
    GamePanel gp;
    Font Luminari, Luminari80;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";


    public UI(GamePanel gp) {
        this.gp = gp;

        Luminari = new Font("Luminari", Font.PLAIN, 40);
        Luminari80 = new Font("Luminari", Font.PLAIN, 70);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(Luminari);
        g2.setColor(Color.white);

        //play
        if (gp.gameState == gp.playState) {

        }
        //pause
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        //dialogue
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }

    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "Paused";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        drawSubWindow(x, y, width, height);
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);

    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXForCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}