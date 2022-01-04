package tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CopyOnWriteArrayList;

public class ToByteTest {

	public static void main(String[] args) {
		try {
			byte[] ok = serializeCannonsList(createCannonsList());
			for (int i = 0; i < ok.length; i++) {
				System.out.println(ok[i]);
			}
			CopyOnWriteArrayList<Cannon> comeOn = (CopyOnWriteArrayList<Cannon>) deserializeCannonsList(ok);
			for (Cannon cannon : comeOn) {
				System.out.println(cannon.getX() + "aja");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static CopyOnWriteArrayList<Cannon> createCannonsList() {
		CopyOnWriteArrayList<Cannon> cannonsList = new CopyOnWriteArrayList<Cannon>();
		cannonsList.add(new Cannon(1, 1, 1));
		cannonsList.add(new Cannon(2, 2, 2));
		cannonsList.add(new Cannon(3, 3, 3));
		return cannonsList;
	}

	private static byte[] serializeCannonsList(CopyOnWriteArrayList<Cannon> cannonsList) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(cannonsList);
		oos.flush();
		byte[] data = bos.toByteArray();
		bos.close();
		return data;
	}

	private static Object deserializeCannonsList(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream is = new ObjectInputStream(in);
		return is.readObject();
	}
}
