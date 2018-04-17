from unittest import TestCase

from probs.prob27.naver import dash_insert


class UnitTestCase(TestCase):
    def test_method(self):
        self.assertEqual("123", dash_insert("123"))
        self.assertEqual("1-3-5", dash_insert("135"))
        self.assertEqual("2+4+6", dash_insert("246"))
        self.assertEqual("454+67-9-3", dash_insert("4546793"))
