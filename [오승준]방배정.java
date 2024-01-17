import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int room = 0;
		int AA =0;
		int AB =0;
		int BA =0;
		int BB =0;
		int CA =0;
		int CB =0;
		int DA =0;
		int DB =0;
		int EA =0;
		int EB =0;
		int FA =0;
		int FB =0;
		
		for(int i = 0; i < N ; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			switch(Y) {
			case 1 :
				if(S == 0) {
					AA += 1;
				} else {
					AB += 1;
				}
				break ;
			case 2 :
				if(S == 0) {
					BA += 1;
				} else {
					BB += 1;
				}
				break ;
			case 3 :
				if(S == 0) {
					CA += 1;
				} else {
					CB += 1;
				}
				break ;
			case 4 :
				if(S == 0) {
					DA += 1;
				} else {
					DB += 1;
				}
				break ;
			case 5 :
				if(S == 0) {
					EA += 1;
				} else {
					EB += 1;
				}
				break ;
			case 6 :
				if(S == 0) {
					FA += 1;
				} else {
					FB += 1;
				}
				break ;
			}
			
		}
		//System.out.print(AA+" "+AB+" "+BA+" "+BB+" "+CA+" "+CB+" "+DA+" "+DB+" "+EA+" "+EB+" "+FA+" "+FB+" \n");
		if (1<=AA && AA<=K) {
			room +=1;
		} else if (AA > K && AA%K ==0) {
			room += AA/K ;
		} else if (AA > K && AA%K !=0) {
			room += AA/K+1;
		}
		if (1<=AB && AB<=K) {
			room +=1;
		} else if (AB > K && AB%K ==0) {
			room += AB/K ;
		} else if (AB > K && AB%K !=0) {
			room += AB/K+1;
		}
		if (1<=BA && BA<=K) {
			room +=1;
		} else if (BA > K && BA%K ==0) {
			room += BA/K ;
		} else if (BA > K && BA%K !=0) {
			room += BA/K+1;
		}
		if (1<=BB && BB<=K) {
			room +=1;
		} else if (BB > K && BB%K ==0) {
			room += BB/K ;
		} else if (BB > K && BB%K !=0) {
			room += BB/K+1;
		}
		if (1<=CA && CA<=K) {
			room +=1;
		} else if (CA > K && CA%K ==0) {
			room += CA/K ;
		} else if (CA > K && CA%K !=0) {
			room += CA/K+1;
		}
		if (1<=CB && CB<=K) {
			room +=1;
		} else if (CB > K && CB%K ==0) {
			room += CB/K ;
		} else if (CB > K && CB%K !=0) {
			room += CB/K+1;
		}
		if (1<=DA && DA<=K) {
			room +=1;
		} else if (DA > K && DA%K ==0) {
			room += DA/K ;
		} else if (DA > K && DA%K !=0) {
			room += DA/K+1;
		}
		if (1<=DB && DB<=K) {
			room +=1;
		} else if (DB > K && DB%K ==0) {
			room += DB/K ;
		} else if (DB > K && DB%K !=0) {
			room += DB/K+1;
		}
		if (1<=EA && EA<=K) {
			room +=1;
		} else if (EA > K && EA%K ==0) {
			room += EA/K ;
		} else if (EA > K && EA%K !=0) {
			room += EA/K+1;
		}
		if (1<=EB && EB<=K) {
			room +=1;
		} else if (EB > K && EB%K ==0) {
			room += EB/K ;
		} else if (EB > K && EB%K !=0) {
			room += EB/K+1;
		}
		if (1<=FA && FA<=K) {
			room +=1;
		} else if (FA > K && FA%K ==0) {
			room += FA/K ;
		} else if (FA > K && FA%K !=0) {
			room += FA/K+1;
		}
		if (1<=FB && FB<=K) {
			room +=1;
		} else if (FB > K && FB%K ==0) {
			room +=FB/K ;
		} else if (FB > K && FB%K !=0) {
			room += FB/K+1;
		}

		System.out.print(room);

	}
}
