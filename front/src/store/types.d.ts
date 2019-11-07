import { Category, Account, History } from '@/types/types';
import ScreenSize from '@/types/enums';

export interface RootState {
  version: string;
}

export interface CommonState {
  screenSize: ScreenSize;
}

export interface CategoryState {
  categories: Category[];
}

export interface AccountState {
  accounts: Account[];
}

export interface HistoryState {
  histories: History[];
}
