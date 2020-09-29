stack<int> temp;
	for (int i = 0; i < moves.size(); i++) {
		int insert_puz = 0;
		int x = moves[i]-1;

		for (int j = 0; j < board.size(); j++) {
            //맨 위에 있는 퍼즐 탐색
			if (board[j][x] != 0) {
				insert_puz = board[j][x];
				board[j][x] = 0; //퍼즐 없애기
				break;
			}
		}

        //insert_puz를 0으로 초기화했기때문에 위에서 아무 퍼즐도 못얻으면 0임. 그래서 예외처리
		if (insert_puz != 0) {
			if (temp.empty()) temp.push(insert_puz); //암것도 없으면 그냥 스택쌓기
			else {
				if (temp.top() == insert_puz) { //만약에 스택 위에 있는 퍼즐이랑 지금 넣으려는 퍼즐이 같으면 퍼즐 없애고 +2
                    //같지 않으면 그냥 삽입
					temp.pop();
					answer+=2;
				}
				else temp.push(insert_puz);
			}
		}
	}
