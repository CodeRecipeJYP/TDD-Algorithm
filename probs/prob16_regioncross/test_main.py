import io
import unittest
from unittest.mock import patch

from probs.prob16_regioncross.regioncross import main


class End2EndTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
-7 5
0 0
-3 -3
4 2
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
6""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_2(self, captured_output):
        raw_input = """\
1 1
0 0
2 2
1 1
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
0""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_3(self, captured_output):
        raw_input = """\
1 1
0 0
2 2
1 1
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
0""", output)
