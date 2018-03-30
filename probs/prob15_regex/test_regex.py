import io
import unittest
from unittest.mock import patch

from probs.prob15_regex.regex import main


class End2EndTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_1(self, captured_output):
        raw_input = """\
1
donGyi kiM
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
Dongyi Kim""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_2(self, captured_output):
        raw_input = """\
3
mijoo lee
JIAE Yoo
jiSOO seo
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
Mijoo Lee
Case #2
Jiae Yoo
Case #3
Jisoo Seo""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_3(self, captured_output):
        raw_input = """\
1
chanJoo leE
"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
Chanjoo Lee""", output)

    @patch('sys.stdout', new_callable=io.StringIO)
    def test_end2end_4(self, captured_output):
        raw_input = """\
2
JaeYOung pArk
hyUnhoo yoo"""
        user_input = raw_input.split("\n")

        with patch('builtins.input', side_effect=user_input):
            main()
            output = captured_output.getvalue()
            output = output.rstrip()

        self.assertEqual("""\
Case #1
Jaeyoung Park
Case #2
Hyunhoo Yoo""", output)
