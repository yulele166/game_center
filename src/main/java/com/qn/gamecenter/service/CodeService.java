package com.qn.gamecenter.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.qn.gamecenter.util.Base64;

/**
 * @user 
 * @date 2016年10月18日
 */
@Service
public class CodeService {
	private String[] codes = new String[] { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };

	public String getRandomStr() {
		Random ran = new Random();
		int length = codes.length;
		String code = "";
		for (int i = 0; i < 10; i++) {
			code += codes[ran.nextInt(length)];
		}
		return code;
	}
	
	public  String getUid(String uid, String time) {
		String uidCode = uid;
		try {
			uidCode = getIMEI(uid, time);
			uidCode = new String(Base64.decode(uidCode.getBytes(),0));
			uidCode = uidCode.replaceAll(" ", "");
		} catch (Exception e) {
			uidCode = null;
		}
		return uidCode;
	}
	/**
	 * IMEI解码
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public  String getIMEI(String id, String time) {

		String imeicode = id;
		String timecode = time;
		int subIndex = timecode.length() * 2 - imeicode.length();
		int removecount = Math.min(imeicode.length() - timecode.length(),
				timecode.length());
		for (int i = 1; i <= removecount; i++) {
			int removeIndex = imeicode.length() - i;
			String before = imeicode.substring(0, removeIndex);
			String after = "";
			if (i > 1)
				after = imeicode.substring(removeIndex + 1);
			imeicode = before + after;
		}
		
		if (subIndex > 0 && subIndex<imeicode.length()) {
			imeicode = imeicode.substring(subIndex);
		}
		return getIMEI(imeicode);
	}
	/**
	 * imei解码
	 * 
	 * @param imei
	 * @return
	 */
	private  String getIMEI(String imei) {

		byte[] temp = null;
		String ret = null;
		try {
			temp = imei.getBytes("utf-8");
			int length = temp.length;
			int count = length / 2 / 2 + (length / 2 % 2 == 0 ? 0 : 1);

			for (int i = 0; i < length / 2 - count; i++) {
				int index = length - 2 * i - 1;
				byte tempByte = temp[i + count];
				temp[i + count] = temp[index];
				temp[index] = tempByte;
			}
			for (int i = 0; i < count; i++) {
				int index = 0;

				if (length % 2 == 0) {
					index = length / 2 + 2 * i;
				} else {
					index = length / 2 + 2 * i + 1;
				}

				byte tempByte = temp[i];
				temp[i] = temp[index];
				temp[index] = tempByte;
			}

			ret = new String(temp);
		} catch (Exception e) {
			ret = null;
		}

		return ret;
	}

}
