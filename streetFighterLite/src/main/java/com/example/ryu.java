package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class ryu extends sprite implements playerUtils {
    private int mode;
    public boolean ryudamage;
    public static int ryucounter = 300;
    private boolean canAttack = true;
    private boolean canDealDamage = true;
    ken ken;

    public boolean isRyudamage() {
        return ryudamage;
    }

    public void setRyudamage(boolean ryudamage) {
        this.ryudamage = ryudamage;
    }

    public static int getRyucounter() {
        return ryucounter;
    }

    public static void setRyucounter(int ryucounter) {
        ryu.ryucounter = ryucounter;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public boolean isCanDealDamage() {
        return canDealDamage;
    }
    
    public void attackWithDelay(Runnable attackAction, int delayMs) {
        if (canAttack) {
            attackAction.run();
            canAttack = false;
            Timer timer = new Timer(delayMs, (e) -> canAttack = true);
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void resetDamageCooldown(int cooldownMs) {
        canDealDamage = false;
        Timer timer = new Timer(cooldownMs, (e) -> canDealDamage = true);
        timer.setRepeats(false);
        timer.start();
    }

    public void move() {
        int newX = getX() + speed;
        int screenWidth = 800;
        int characterWidth = getW();
    
        if (newX < 0) {
            newX = 0;
        } else if (newX + characterWidth > screenWidth) {
            newX = screenWidth - characterWidth;
        }
    
        setX(newX);
    }

    public void jump() {
        if (y == FLOOR - h) {
            mode = JUMP;
            new Thread(() -> {
                int jumpHeight = 125;
                int jumpSpeed = 5;

                for (int i = 0; i < jumpHeight; i += jumpSpeed) {
                    y -= jumpSpeed;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < jumpHeight; i += jumpSpeed) {
                    y += jumpSpeed;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mode = WALK;
            }).start();
        }
    }
    
    ryu(int x, int y) {
        loadImage(ryu.this);
        loadWalk();
        loadPunch();
        loadJump();
        loadKick();
        loadPower();
        loadDefence();
        mode = WALK;
        this.x = x;
        this.w = this.h = 150;
        this.y = FLOOR - this.h;
    }
    
    BufferedImage walkImages[] = new BufferedImage[6];
    public void loadWalk() {
        walkImages[0] = img.getSubimage(5, 641, 63, 89);
        walkImages[1] = img.getSubimage(70, 636, 69, 93);
        walkImages[2] = img.getSubimage(144, 635, 67, 95);
        walkImages[3] = img.getSubimage(221, 634, 60, 95);
        walkImages[4] = img.getSubimage(296, 635, 54, 94);
        walkImages[5] = img.getSubimage(364, 636, 56, 93);
    }
    
    BufferedImage punchImages[] = new BufferedImage[6];
    public void loadPunch() {
        punchImages[0] = img.getSubimage(273, 1421, 65, 94);
        punchImages[1] = img.getSubimage(345, 1421, 71, 94);
        punchImages[2] = img.getSubimage(345, 1421, 71, 94);
        punchImages[3] = img.getSubimage(421, 1422, 109, 93);
        punchImages[4] = img.getSubimage(421, 1422, 109, 93);
        punchImages[5] = img.getSubimage(345, 1421, 71, 94);
    }
    
    BufferedImage jumpImages[] = new BufferedImage[6];
    public void loadJump() {
        jumpImages[0] = img.getSubimage(792, 1194, 63, 108);
        jumpImages[1] = img.getSubimage(861, 1151, 65, 88);
        jumpImages[2] = img.getSubimage(932, 1124, 61, 70);
        jumpImages[3] = img.getSubimage(932, 1124, 61, 70);
        jumpImages[4] = img.getSubimage(861, 1151, 65, 88);
        jumpImages[5] = img.getSubimage(792, 1194, 63, 108);
    }
    
    BufferedImage kickImages[] = new BufferedImage[7];
    public void loadKick() {
        kickImages[0] = img.getSubimage(430, 2559, 65, 94);
        kickImages[1] = img.getSubimage(497, 2559, 67, 94);
        kickImages[2] = img.getSubimage(566, 2559, 65, 94);
        kickImages[3] = img.getSubimage(656, 2563, 118, 90);
        kickImages[4] = img.getSubimage(656, 2563, 118, 90);
        kickImages[5] = img.getSubimage(566, 2559, 65, 94);
        kickImages[6] = img.getSubimage(497, 2559, 67, 94);
    }
    
    BufferedImage powerImages[] = new BufferedImage[1];
    public void loadPower() {
        powerImages[0] = img.getSubimage(925, 5105, 133, 129);
    }

    BufferedImage defenceImages[] = new BufferedImage[6];
    public void loadDefence() {
        defenceImages[0] = img.getSubimage(3, 4658, 65, 92);
        defenceImages[1] = img.getSubimage(3, 4658, 65, 92);
        defenceImages[2] = img.getSubimage(3, 4658, 65, 92);
        defenceImages[3] = img.getSubimage(70, 4659, 68, 91);
        defenceImages[4] = img.getSubimage(70, 4659, 68, 91);
        defenceImages[5] = img.getSubimage(70, 4659, 68, 91);		
    }
    
    private int punchIndex = 0;
    private void drawPunch(Graphics g) {
        g.drawImage(punchImages[punchIndex], x, y, w, h, null);
        punchIndex++;
        if (punchIndex == punchImages.length) {
            punchIndex = 0;
            mode = WALK;
        }
    }
    
    private int walkIndex = 0;
    private void drawWalk(Graphics g) {
        g.drawImage(walkImages[walkIndex], x, y, w, h, null);
        walkIndex++;
        if (walkIndex == walkImages.length) {
            walkIndex = 0;
        }
    }
    
    private int jumpIndex = 0;
    private void drawJump(Graphics g) {
        g.drawImage(jumpImages[jumpIndex], x, y, w, h, null);
        jumpIndex++;
        if (jumpIndex == jumpImages.length) {
            jumpIndex = 0;
            mode = WALK;
        }
    }

    private int kickIndex = 0;
    private void drawKick(Graphics g) {
        g.drawImage(kickImages[kickIndex], x, y, w, h, null);
        kickIndex++;
        if (kickIndex == kickImages.length) {
            kickIndex = 0;
            mode = WALK;
        }
    }
    
    private int powerIndex = 0;
    private void drawPower(Graphics g) {
        g.drawImage(powerImages[powerIndex], x, y, w, h, null);
        powerIndex++;
        if (powerIndex == powerImages.length) {
            powerIndex = 0;
            mode = WALK;
        }
    }

    private int defenceIndex = 0;	
    private void drawDefence(Graphics g) {
        g.drawImage(defenceImages[defenceIndex], x, y, w, h, null);
        defenceIndex++;
        if (defenceIndex == defenceImages.length) {
            defenceIndex = 0;
            mode = WALK;
        }
    }
    
    @Override
    public void draw(Graphics g) {
        switch (getMode()) {
            case (WALK):
                drawWalk(g);
                break;
            case (PUNCH):
                drawPunch(g);
                break;
            case (KICK):
                drawKick(g);
                break;
            case (POWER):
                drawPower(g);
                break;
            case (JUMP):
                drawJump(g);
                break;
            case (DEFENCE):
                drawDefence(g);
                break;
        }
    }
    
    int barwidth = 300;
    public int drawProgress(Graphics g) {
        barwidth = barwidth - 20;
        g.setColor(Color.RED);
        g.fillRect(40, 40, barwidth, 40);
        return barwidth;
    }
}