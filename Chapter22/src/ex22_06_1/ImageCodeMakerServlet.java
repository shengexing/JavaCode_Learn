// �½�22.06.1            ʹ��Servlet����ͼ����֤��
package ex22_06_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ͼ����֤���Servlet
 */
public class ImageCodeMakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageCodeMakerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��������ҳ�治����
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		System.out.println("ִ��doPost()������");
		
		// ����ͼƬ�Ŀ�Ⱥ͸߶�
		int width = 90, height = 40;
		// ����һ��ͼ�����
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// �õ�ͼ��Ļ�������
		Graphics g = image.createGraphics();
		
		Random random = new Random();
		
		// �������ɫ���ͼ�񱳾�
		g.setColor(getRandColor(180, 250));
		g.fillRect(0, 0, width, height);
		for(int i = 0; i < 5; i++) {
			g.setColor(getRandColor(50, 100));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			g.drawOval(x, y, 4, 4);
		}
		g.setFont(new Font("", Font.PLAIN, 40)); 		// �������壬����׼���������
		String sRand = ""; 		// ��������ַ���
		for(int i = 0; i < 4; i++) {
			// �����ĸ����ַ���
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			
			// ���������ɫ
			g.setColor(new Color(20 + random.nextInt(80), 20 + random.nextInt(100), 20 + random.nextInt(90)));
			
			// ��������ֻ���ͼ����
			g.drawString(rand, (17 + random.nextInt(3)) * i + 8, 34);
			
			// ���ɸ�����
			for(int k = 0; k < 12; k++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int x1 = random.nextInt(9);
				int y1 = random.nextInt(9);
				g.drawLine(x, y, x + x1, y + y1);
			}
		}
		
		// �����ɵ���������ַ���д��session
		request.getSession().setAttribute("randcode", sRand);
		g.dispose(); 			// ʹͼ����Ч
		ImageIO.write(image, "JPEG", response.getOutputStream()); 			// ���ͼ��ҳ��
	}
	
	/**
	 * ����һ���������ɫ
	 * @param fc 		��ɫ������Сֵ
	 * @param bc 		��ɫ�������ֵ
	 */
	public Color getRandColor(int fc, int bc) {
		Random random = new Random();
		
		if(fc > 255)
			fc = 255;
		if(bc > 255)
			bc = 255;
		
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		
		return new Color(r, g, b);
	}

}
