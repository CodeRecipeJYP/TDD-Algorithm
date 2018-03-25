import io
import unittest
from unittest.mock import patch

from probs.prob05_routing.routing import main

"""
예제 입력 
10101111
01111101
11001110
00000010
2
3 -1
1 1
예제 출력 
7
예제 입력 2 
11111111
11111111
11111111
11111111
3
1 1
2 1
3 1
예제 출력 2 
15
예제 입력 3 
10001011
10000011
01011011
00111101
5
1 1
2 1
3 1
4 1
1 -1
예제 출력 3 
6
예제 입력 4 
10010011
01010011
11100011
01010101
8
1 1
2 1
3 1
4 1
1 -1
2 -1
3 -1
4 -1
예제 출력 4 
5

"""


class RoutingTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
10101111
01111101
11001110
00000010
2
3 -1
1 1
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("7", output)
