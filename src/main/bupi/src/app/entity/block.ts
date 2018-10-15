import {Transaction} from './transaction'

export class Block {

  constructor()
  {
    this.collapsed = true;
  }

  hash: string;
  previousHash: string;
  transactions: Transaction[];
  nonce: number;
  collapsed : boolean;
}
