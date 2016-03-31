package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class ScreenManager {

    private GraphicsDevice graphicsDevice;

    public ScreenManager() {
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = environment.getDefaultScreenDevice();
    }

    public DisplayMode findFirstCompatibaleMode(DisplayMode[] modes) {
        DisplayMode goodModes[] = graphicsDevice.getDisplayModes();

        for (DisplayMode mode : modes) {
            for (DisplayMode goodMode : goodModes) {
                if (displayModesMatch(mode, goodMode)) {
                    return mode;
                }
            }
        }

        return null;
    }

    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
            return false;
        }

        if (m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) {
            return false;
        }

        if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate()) {
            return false;
        }

        return true;
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(displayMode);
            } catch (Exception ex) {
                //
            }

            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window window = graphicsDevice.getFullScreenWindow();

        // return window != null ? (Graphics2D) window.getBufferStrategy().getDrawGraphics() : null;

        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();
            return (Graphics2D) bufferStrategy.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window window = graphicsDevice.getFullScreenWindow();

        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();

            if (!bufferStrategy.contentsLost()) {
                bufferStrategy.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public int getWidth() {
        Window window = graphicsDevice.getFullScreenWindow();

        // return window != null ? window.getWidth() : 0;

        if (window != null) {
            return window.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window window = graphicsDevice.getFullScreenWindow();

        // return window != null ? window.getHeight() : 0;

        if (window != null) {
            return window.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window window = graphicsDevice.getFullScreenWindow();

        if (window != null) {
            window.dispose();
        }

        graphicsDevice.setFullScreenWindow(null);
    }

}
