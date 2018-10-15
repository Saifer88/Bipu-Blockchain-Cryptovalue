import {Transaction} from './transaction';
import {Block} from './block';



export class BlockChain
{
  pendingTransactions: Transaction[];
  blocks : Block[];
  difficulty: number;
}
