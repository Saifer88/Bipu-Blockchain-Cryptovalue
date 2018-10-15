import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../entity/transaction';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.less']
})
export class TransactionComponent implements OnInit {

  @Input() transaction : Transaction;
  @Input()  index : number;

  constructor() { }

  ngOnInit() {
  }

}
