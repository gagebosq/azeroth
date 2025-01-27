package entity;

import Main.AssetSetter;
import Main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/oldman_up_1");
        up2 = setup("/npc/oldman_up_2");
        down1 = setup("/npc/oldman_down_1");
        down2 = setup("/npc/oldman_down_2");
        left1 = setup("/npc/oldman_left_1");
        left2 = setup("/npc/oldman_left_2");
        right1 = setup("/npc/oldman_right_1");
        right2 = setup("/npc/oldman_right_2");
    }

    public void setDialogue() {
        String newline = System.lineSeparator();

        dialogues[0] = "Hello there.";
        dialogues[1] = "How did you even get on this island lol.";
        dialogues[2] = "I feel im too old to join you... may your \nluck steer you deep into the treasures \nof this island.";
        dialogues[3] = "God damn im old as shit.";
        dialogues[4] = "Shall you find the hidden treasure...give \nme some.";
        dialogues[5] = "Im a wizard btw... ive got some tricks ;)";
        dialogues[6] = "Fear the guy they call... mr. skeleton guy";


    }

    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;// seed
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }

    public void speak() {
        super.speak();

    }
}
