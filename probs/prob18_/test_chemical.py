import io
import unittest
from unittest.mock import patch

from probs.prob18_.chemical import main


class End2EndTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
5
3 0
40 95 21
7 500
25 60 400 250 0 60 0
4 10
90 95 75 95
4 11
90 95 75 95
5 333
0 0 0 0 0
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
2
Case #2
8
Case #3
2
Case #4
3
Case #5
4""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_2(self, captured_output):
        raw_input = """\
1
7 500
25 60 400 250 0 60 0
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
8""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_3(self, captured_output):
        raw_input = """\
1
4 10
90 95 75 95
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
2""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_4(self, captured_output):
        raw_input = """\
1
4 11
90 95 75 95
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
3""", output)
