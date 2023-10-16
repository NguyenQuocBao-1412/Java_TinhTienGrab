import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check;
		String[] danhSachLoaiXe = {"Grab car", "Grab suv", "Grab black"};
		String loaiXe;
		float soKM, tongTien;
		int thoiGianCho;
		
		Scanner scan = new Scanner(System.in);
		
		//Nhap loai xe
		do {
			check = true;
			
			System.out.print("Moi ban nhap loai xe: ");
			loaiXe = scan.nextLine().trim();
			
			int n = danhSachLoaiXe.length;
			for(int i = 0; i < n; i++) {
				if(loaiXe.equalsIgnoreCase(danhSachLoaiXe[i])) {
					check = false;
					break;
				}
			}
			
			if(check == true)
				System.out.println("Nhap loai xe chua dung. Moi nhap lai!");
		} while(check);
		//!loaiXe.equalsIgnoreCase("Grab car") && !loaiXe.equalsIgnoreCase("Grab suv") && !loaiXe.equalsIgnoreCase("Grab black")
		
		// Nhap so KM
		do {
			
			System.out.print("Moi ban nhap so KM: ");
			soKM = scan.nextFloat();
			
			if(soKM <= 0)
				System.out.println("So KM chua hop le. Moi ban nhap lai!");
		} while(soKM <= 0);
		
		// Nhap thoi gian cho
		do {
			
			System.out.print("Moi ban nhap thoi gian cho: ");
			thoiGianCho = scan.nextInt();
			
			if(thoiGianCho < 0)
				System.out.println("Thoi gian cho chua hop le. Moi ban nhap lai!");
		} while(thoiGianCho < 0);
		
		System.out.println("Loai xe: " + loaiXe);
		System.out.println("So KM: " + soKM);
		System.out.println("Thoi gian cho: " + thoiGianCho);
		
		tongTien = TongTien(loaiXe, soKM, thoiGianCho);
		System.out.println("Tong tien la: " + tongTien);
		
		System.out.print("=====End=====");
	}
	
	public static float TongTien(String loaiXe, float soKM, int thoiGianCho) {
		int giaCuocKmDau = 0, giaCuoc1Toi19 = 0, giaCuocTren19 = 0, giaCuocThoiGianCho = 0;
		float tongTien = 0;
		
		if(loaiXe.equalsIgnoreCase("grab car")) {
			giaCuocKmDau = 8000;
			giaCuoc1Toi19 = 7500;
			giaCuocTren19 = 7000;
			giaCuocThoiGianCho = 2000;
		} else if (loaiXe.equalsIgnoreCase("grab suv")) {
			giaCuocKmDau = 9000;
			giaCuoc1Toi19 = 8500;
			giaCuocTren19 = 8000;
			giaCuocThoiGianCho = 3000;
		} else if (loaiXe.equalsIgnoreCase("grab black")) {
			giaCuocKmDau = 10000;
			giaCuoc1Toi19 = 9500;
			giaCuocTren19 = 9000;
			giaCuocThoiGianCho = 3500;
		}
		
		tongTien = (float)giaCuocKmDau;
		
		if(soKM > 1 && soKM < 19) {
			tongTien += (float)(soKM - 1) * giaCuoc1Toi19;
		} else if (soKM > 19) {
			tongTien += (float)(18) * giaCuoc1Toi19;
			tongTien += (float)(soKM - 19) * giaCuocTren19;
		}
		
		if(thoiGianCho >= 3) {
			tongTien += thoiGianCho / 3 * giaCuocThoiGianCho;
		}
		
		return tongTien;
	}
	
}
