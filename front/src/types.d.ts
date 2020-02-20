import { ScreenSize } from '@/constant';

declare global {
  namespace Type {
    type Lang = 'ko' | 'en';

    type Unit = 'PLUS' | 'MINUS';

    interface Response<T> {
      code: number;
      data: T;
    }

    interface Category {
      idx: number;
      unit: Unit;
      name: string;
      icon: string;
      parentIdx: number;
    }

    interface Account {
      idx: number;
      name: string;
      color: string;
      initialBalance: string;
    }

    interface History {
      idx: number;
      date: string;
      unit: Unit;
      accountIdx: number;
      categoryIdx: number;
      title: string;
      message: string;
      price: number;
    }
  }

  namespace Store {
    interface RootState {
      version: string;
    }

    interface CommonState {
      screenSize: ScreenSize;
    }

    interface CategoryState {
      categories: Type.Category[];
    }

    interface AccountState {
      accounts: Type.Account[];
    }

    interface HistoryState {
      histories: Type.History[];
    }
  }
}
