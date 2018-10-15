import { User } from "./user";

export class Transaction
{
  sender: User;
  receiver: User;
  amount: number;
}
