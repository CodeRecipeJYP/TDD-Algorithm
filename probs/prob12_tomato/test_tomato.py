import io
import unittest
from unittest.mock import patch

from probs.prob12_tomato.tomato import main

"""
예제 입력 1
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
예제 출력 1
8

예제 입력 2
6 4
0 -1 0 0 0 0
-1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
예제 출력 2
-1

예제 입력 3
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
예제 출력 3
6

예제 입력 4
5 5
-1 1 0 0 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 0 0 0 0
예제 출력 4
14

예제 입력 5
2 2
1 -1
-1 1
예제 출력 5
0


"""


class End2EndTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("8", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_2(self, captured_output):
        raw_input = """\
6 4
0 -1 0 0 0 0
-1 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("-1", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_3(self, captured_output):
        raw_input = """\
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
    """
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("6", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_4(self, captured_output):
        raw_input = """\
5 5
-1 1 0 0 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 -1 -1 -1 0
0 0 0 0 0
        """
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("14", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_5(self, captured_output):
        raw_input = """\
2 2
1 -1
-1 1
            """
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("0", output)
