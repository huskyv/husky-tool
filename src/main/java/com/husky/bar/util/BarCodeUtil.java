/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.husky.bar.util;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import com.husky.io.util.FileUtil;

/**
 * 
 * @author husky
 */
public class BarCodeUtil {
	/**
	 * husky
	 * 
	 * @param str
	 *            条码
	 * @param path
	 *            生成路径,自动创建不存在的目录
	 */
	public static void exportBarCode(String str, String path) {
		try {
			JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
			// 生成. 欧洲商品条码(=European Article Number)
			// 这里我们用作图书条码
			// String str = "959009257120";
			// 默认
			localJBarcode.setEncoder(Code39Encoder.getInstance());
			localJBarcode.setPainter(WideRatioCodedPainter.getInstance());
			localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
			localJBarcode.setShowCheckDigit(false);
			BufferedImage localBufferedImage = localJBarcode.createBarcode(str);
			saveToFile(localBufferedImage, path);
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param paramBufferedImage
	 *            流
	 * @param path
	 *            路径
	 */
	public static void saveToFile(BufferedImage paramBufferedImage, String path) throws Exception {
		FileUtil.createFolderOrFile(path);
		String paramString = FilenameUtils.getExtension(path);
		try {
			FileOutputStream fos = new FileOutputStream(path);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString, bos, 96, 96);
			bos.flush();
			fos.flush();
			bos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		exportBarCode("1234567890","D://1.png");
	}

}
