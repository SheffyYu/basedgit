import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import GameOfLifeFrame.GPanel;


public class GameOfLifeTest {
	private static Game game = new Game();
	@Before
	public void setUp() throws Exception {
		game.InitGameMap();
	}
	
	@Test
	//���Ե�Ԫ�������Χ��ϸ�����ĺ���
	public void testGetNeighborCount() {
		assertEquals(4,game.GetNeighborCount(3,3));
	}
	
	@Test
	//������һ��GameMap
	public void testInitNewMap(){
		
	}

	@Test
	//���Ը��µ�ͼ����
	public void testUpdateGameMap(){
		
	}
}
