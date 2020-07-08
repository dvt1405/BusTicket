public class Encrypt {
    static {
        System.loadLibrary("crypto");
        System.loadLibrary("ssl");
        System.loadLibrary("MyBridge");
    }

    native String encrypt(String code, String number);

    public String[] process(String code, String number) {
        String res = encrypt(code, number);
        String[] t = new String[2];
        if (res.length() == 4) {
            t[0] = res.substring(1);
            t[1] = res.substring(0, 1);
        }
        return t;
    }

//	public static void main(String args[]) {
//		Encrypt e = new Encrypt();
//		//System.loadLibrary("MyBridge");
//		String code = "9094";
//		String number = "30A-100.01";
//		//String otp=null;
//		//String color=null;
//		while(true) {
//			String[] t = e.process(code,number);
//			System.out.println("otp:["+t[0]+"], color:["+t[1]+"]");
//			try {
//				Thread.sleep(5000);
//			}catch(Exception e1) {
//			}
//		}
//	}

}
