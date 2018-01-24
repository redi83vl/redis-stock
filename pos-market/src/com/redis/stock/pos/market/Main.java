/*
 * Copyright (C) 2017 Redjan Shabani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redis.stock.pos.market;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Redjan Shabani
 */
public final class Main {	
	
	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(com.jtattoo.plaf.aero.AeroLookAndFeel.class.getName());
//			UIManager.setLookAndFeel(com.jtattoo.plaf.noire.NoireLookAndFeel.class.getName());
			UIManager.setLookAndFeel(com.jtattoo.plaf.texture.TextureLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(() -> {
			new FrameMain().setVisible(true);
		});
	}
}
