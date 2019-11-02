import { Unit } from './enums';

export interface Response<T> {
  code: number;
  data: T;
}

export interface Category {
  idx: number;
  unit: Unit;
  name: string;
  parentIdx: number;
}

export interface Account {
  idx: number;
  name: string;
  color: string;
  initialBalance: string;
}

export interface History {
  idx: number;
  date: string;
  unit: Unit;
  accountIdx: number;
  categoryIdx: number;
  title: string;
  message: string;
  price: number;
}
