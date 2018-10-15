import { Injectable } from '@angular/core';

import {BlockChain} from './entity/blockchain'


import { Observable,  interval } from 'rxjs';

import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class BlockchainService {

  http : HttpClient;

  blockchain = {
    url : "http://localhost:8080/blockchain"
  }



  getBlockChain() : Observable<BlockChain>
  {
      return this.http.get<BlockChain>(this.blockchain.url);
  }

  getInterval(): Observable<number>
  {
    return interval(2000);
  }


  constructor(http : HttpClient) {
      this.http = http;
   }
}
