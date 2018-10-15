import { Component, OnInit } from '@angular/core';

import {BlockChain} from '../entity/blockchain';

import {BlockchainService} from '../blockchain.service'
import { trigger, state, transition, style, animate } from '@angular/animations';
import { interval } from 'rxjs';


@Component({
  selector: 'app-blocks',
  templateUrl: './blocks.component.html',
  styleUrls: ['./blocks.component.less'],
  animations: [
    trigger('simpleFadeAnimation', [
      state('in', style({opacity: 1})),
      transition(':enter', [style({opacity: 0}),animate(600 )]),
      transition(':leave', animate(600, style({opacity: 0})))
    ])
  ]
})
export class BlocksComponent implements OnInit {

  blockChain : BlockChain = new BlockChain();
  bcService : BlockchainService;

  successMessage : string = "New Block Created";
  notifyNewBlock: boolean = false;

  constructor(bcService : BlockchainService)
  {
    this.bcService = bcService;
  }

  ngOnInit()
  {
    this.bcService.getBlockChain().subscribe(bc => this.blockChain = bc);

    interval(2000)
    .subscribe(() =>
    this
      .bcService
      .getBlockChain()
      .subscribe(bc =>
        {
          if (bc.blocks.length > this.blockChain.blocks.length)
          {
            this.blockChain.blocks.push(bc.blocks[this.blockChain.blocks.length]);
            this.showMessage();
          }
        }
    ));
  }

  showMessage()
  {
    this.notifyNewBlock = true;
    interval(5000).subscribe(() => this.notifyNewBlock = false);
  }
}
