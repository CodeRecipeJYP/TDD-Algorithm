import io
import unittest
from unittest.mock import patch

from probs.prob17_.tracepath import main


class End2EndTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
2
3 4
7 2
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
1 2 3 4
10 11 12 5
9 8 7 6
Case #2
1 2
14 3
13 4
12 5
11 6
10 7
9 8""", output)
